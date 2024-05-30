import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

//유저 데이터 예시
const userData = [
  { ID: "user1", password: "password1" },
  { ID: "user2", password: "password2" },
];

const Login = () => {
  const [id, setID] = useState("");
  const [password, setPassword] = useState("");
  const [isButtonDisabled, setIsButtonDisabled] = useState(true);
  const [errorMessage, setErrorMessage] = useState("");
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

    //유저 데이터에서 입력한 아이디와 비밀번호가 일치하는지 확인
    const user = userData.find(
      (user) => user.ID === id && user.password === password
    );

    if (user) {
      //로그인 성공
      console.log("Login successful");
      navigate("/dashboard"); //로그인 후 이동할 페이지
    } else {
      //로그인 실패
      setErrorMessage("가입된 정보가 없습니다.");
    }
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

        <button type="submit" disabled={isButtonDisabled}>
          Login
        </button>
      </form>
      {errorMessage && <div className="error-message">{errorMessage}</div>}
    </div>
  );
};

export default Login;
