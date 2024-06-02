import { useParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import "./ProjectDetail.css";
import Prolist from "./Prolist";

const ProjectDetail = ({ projects }) => {
  const { p_id } = useParams();
  const navigate = useNavigate();
  const project = projects.find((project) => project.p_id === parseInt(p_id));

  if (!project) {
    return <div>프로젝트를 찾을 수 없습니다.</div>;
  }

  const gotoSignup = () => {
    navigate(`/ProjectDetail/SignUp/${p_id}`);
  };

  return (
    <div className="ProjectDetail">
      <button onClick={gotoSignup}>계정추가</button>
      <h5>프로젝트 상세</h5>
      <h3>{project.p_name}</h3>
      <h4>게시자 : {project.Admin_id}</h4>
      <h3>프로젝트 상세내용 띄우기</h3>
      <h4>👇이슈 등록하기👇</h4>
    </div>
  );
};

export default ProjectDetail;
