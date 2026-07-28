import { useState, useEffect } from 'react';
import './App.css';

function App() {
  const [sedi, setSedi] = useState([]);
  const [sedeId, setSedeId] = useState(null);
  const [aule, setAule] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/sedi')
        .then(res => res.json())
        .then(data => {
          setSedi(data);
          if (data.length > 0) setSedeId(data[0].id);
        })
        .catch(err => console.error('Errore nel caricamento sedi:', err));
  }, []);

  useEffect(() => {
    if (!sedeId) return;
    fetch(`http://localhost:8080/api/sedi/${sedeId}/aule`)
        .then(res => res.json())
        .then(data => setAule(data))
        .catch(err => console.error('Errore nel caricamento aule:', err));
  }, [sedeId]);

  return (
      <div className="app-container">
        <h1>Aule per sede</h1>
        <select className="app-select" value={sedeId || ''} onChange={e => setSedeId(e.target.value)}>
          {sedi.map(s => (
              <option key={s.id} value={s.id}>{s.nome}</option>
          ))}
        </select>
        <table className="app-table">
          <thead>
          <tr><th>Aula</th><th>Capienza</th><th>Dotazioni</th></tr>
          </thead>
          <tbody>
          {aule.map(a => (
              <tr key={a.id}>
                <td>{a.nome}</td>
                <td>{a.capienza}</td>
                <td>{a.dotazioni}</td>
              </tr>
          ))}
          </tbody>
        </table>
      </div>
  );
}

export default App;