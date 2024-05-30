import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

const Login = () => {
  const [id, setID] = useState("");
  const [password, setPassword] = useState("");
  const [isButtonDisabled, setIsButtonDisabled] = useState(true);
  const navigate = useNavigate();

  useEffect(() => {
    //아이디와 비밀번호가 모두 입력된 경우 버튼을 활성화
    if (id && password) {
      setIsButtonDisabled(false);
    } else {
      setIsButtonDisabled(true);
    }
  }, [id, password]);

  const handleSubmit = (e) => {
    e.preventDefault();
    //여기에 로그인 로직 추가
    console.log("ID:", id);
    console.log("Password:", password);
    navigate("/dashboard"); //로그인 후 이동할 페이지(프로젝트페이지)
  };

  return (
    <div className="login-container">
      <h2>Login</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>ID:</label>
          <input
            type="id"
            value={id}
            onChange={(e) => setID(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Password:</label>
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default Login;
