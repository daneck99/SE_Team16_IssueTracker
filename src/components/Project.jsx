import "./Project.css";
import { Link, useNavigate } from "react-router-dom";

const Project = ({ p_id, p_name, Admin_id, date, onDelete }) => {
  //삭제 버튼 누르면 삭제 됨
  const onClickDeleteButton = () => {
    onDelete(p_id);
  };
  // 프로젝트 이름 누르면 프로젝트 상세내용 창이 뜸
  //링크는 각각의 pid 로 동적으로 받아옴
  const navigate = useNavigate();
  const gotoProjectDetail = () => {
    navigate(`/ProjectDetail/${p_id}`);
  };

  return (
    <div className="Project">
      <div className="p_name" onClick={gotoProjectDetail}>
        {p_name}
      </div>
      <div className="date">{new Date(date).toLocaleDateString()}</div>
      <div className="Admin">{Admin_id}</div>
      <button onClick={onClickDeleteButton}>삭제</button>
    </div>
  );
};

export default Project;
