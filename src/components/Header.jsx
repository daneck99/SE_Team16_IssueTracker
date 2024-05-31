import "./Header.css";
import { useNavigate } from "react-router-dom";

const Header = () => {
  // 통계 조회 버튼 누르면 통계 조회 창으로 가게
  const navigate = useNavigate();
  const gotoStatistic = () => {
    navigate(`/Statistic`);
  };
  // 로그아웃 버튼 누르면 로그인 창으로 가게
  const gotoLogin = () => {
    navigate(`/`);
  };

  return (
    <>
      <div className="Header">
        <h3>Issue Management System</h3>
        <div>
          <button onClick={gotoStatistic}>통계 조회</button>
          <button onClick={gotoLogin}>로그아웃</button>
        </div>
      </div>
      <div className="Header">
        <input placeholder="프로젝트 이름" />
        <input placeholder="프로젝트 내용" />
        <button>등록</button>
      </div>
    </>
  );
};

export default Header;
