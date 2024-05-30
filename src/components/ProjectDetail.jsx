import { useParams } from "react-router-dom";
import "./ProjectDetail.css";
import Prolist from "./Prolist";

const ProjectDetail = ({ projects }) => {
  const { p_id } = useParams();
  const project = projects.find((project) => project.p_id === parseInt(p_id));

  if (!project) {
    return <div>프로젝트를 찾을 수 없습니다.</div>;
  }
  /* const gotoAddAccount = () => {
    navigate(`/ProjectDetail/AddAcount${p_id}`);
  };*/
  // 계정 추가 버튼누르면 계정추가 페이지로 : 지영이가 구현

  return (
    <div className="ProjectDetail">
      <button>계정추가</button>
      <h5>프로젝트 상세</h5>
      <h3>{project.p_name}</h3>
      <h4>게시자 : {project.Admin_id}</h4>
      <h3>프로젝트 상세내용 띄우기</h3>
      <h4>👇이슈 등록하기👇</h4>
    </div>
  );
};

export default ProjectDetail;
