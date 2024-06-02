import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import "./SignUp.css";

//유저 데이터(예시)
const existUsers = [{ email: "user1@gmail.com" }, { email: "user2@naver.com" }];

const SignUp = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [isButtonDisabled, setIsButtonDisabled] = useState(true);
  const [errorMessage, setErrorMessage] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    //이름, 이메일, 비밀번호가 모두 입력된 경우 버튼 활성화
    if (name && email && password) {
      setIsButtonDisabled(false);
    } else {
      setIsButtonDisabled(true);
    }
  }, [name, email, password]);

  const handleSubmit = (e) => {
    e.preventDefault();

    //이메일 중복검사
    const emailExists = existUsers.some((user) => user.email === email);
    if (emailExists) {
      setErrorMessage("이미 가입된 이메일입니다");
      return;
    }

    //여기에 실제 회원가입 로직 추가(서버에 데이터 전송)
    console.log("Sign Up successful");
    navigate("/"); //회원가입 후 이동할 페이지
  };

  return (
    <div className="wrapper">
      <div className="signup-container">
        <div className="signup-form">
          <h2>Sign Up</h2>
          <form onSubmit={handleSubmit}>
            <div>
              <label>Name :</label>
              <input
                type="text"
                value={name}
                onChange={(e) => setName(e.target.value)}
                required
              />
            </div>

            <div>
              <label>Email :</label>
              <input
                type="email"
                value={email}
                onChange={(e) => setEmail(e.target.valu)}
                required
              />
            </div>
            <div>
              <label>Password :</label>
              <input
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </div>
            <button type="submit" disabled={isButtonDisabled}>
              Sign Up
            </button>
          </form>
          {errorMessage && <div className="error-message">{errorMessage}</div>}
        </div>
      </div>
    </div>
  );
};

export default SignUp;
