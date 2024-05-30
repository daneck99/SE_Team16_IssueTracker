import "./Project.css";
import { Link, useNavigate } from "react-router-dom";

// db에서 받아와야 확실히 알 수 있을듯..

const Issue = ({
  i_id,
  i_name,
  desciption,
  user_name,
  i_state,
  date,
  onDelete,
}) => {
  //삭제 버튼 누르면 삭제 됨
  const onClickDeleteButton = () => {
    onDelete(i_id);
  };

  // 프로젝트 이름 누르면 프로젝트 상세내용 창이 뜸
  //링크는 각각의 pid 로 동적으로 받아옴
  const navigate = useNavigate();
  const gotoIssueDetail = () => {
    navigate(`/IssueDetail/${i_id}`);
  };

  return (
    <div className="Project">
      <div className="i_name" onClick={gotoIssueDetail}>
        이슈 이름
      </div>
      <div className="date">{new Date(date).toLocaleDateString()}</div>
      <div className="username">{user_name}</div>
      <button onClick={onClickDeleteButton}>삭제</button>
    </div>
  );
};

export default Issue;
