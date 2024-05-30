import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Login from "./components/Login";

const App = () => {
  return (
    <Router>
      <div className="Ap">
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/dashboard" element={<div>Dashboard</div>} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
