import "./Header.css";

const Header = () => {
  return (
    <>
      <div className="Header">
        <h3>Issue Management System</h3>
        <div>
          <button>통계 조회</button>
          <button>로그아웃</button>
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
