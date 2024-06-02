import { useParams } from "react-router-dom";
import { useState } from "react";
import Select from "react-select";
import "./ProjectDetail.css";
import Modal from "./Modal";
import Issue from "./Issue";

const IssueDetail = ({ issues }) => {
  const { i_id } = useParams();
  const issue = issues.find((issue) => issue.i_id === parseInt(i_id));
  // 상태 변경 옵션
  const IssueState = [
    { value: "new", label: "new" },
    { value: "assigned", label: "assigned" },
    { value: "resolved", label: "resolved" },
    { value: "closed", label: "closed" },
    { value: "fixed", label: "fixed" },
    { value: "reopened", label: "reopened" },
  ];
  // 옵션으로 들어오는 값을 받아야됨
  const [selectIssueState, setselectIssueState] = useState(IssueState[0]);

  //상태변경 팝업창
  const [modalOpen, setModalOpen] = useState(false);

  const openModal = () => {
    setModalOpen(true);
  };
  const closeModal = () => {
    setModalOpen(false);
  };

  return (
    <div className="ProjectDetail">
      <div>
        <button>이슈 삭제</button>
      </div>

      <h5>이슈 id: </h5>
      <h3>이슈 제목 </h3>
      <h4>게시자 :</h4>
      <h3>이슈 상세내용 띄우기</h3>
      <Select onChange={setselectIssueState} options={IssueState}>
        이슈 상태
      </Select>
      <button onClick={openModal}>상태 변경</button>
      <Modal open={modalOpen} close={closeModal} header="이슈 상태 변경">
        이슈 상태가 성공적으로 변경되었습니다.
      </Modal>
      <h4>👇댓글 작성하기👇</h4>
    </div>
  );
};

export default IssueDetail;
