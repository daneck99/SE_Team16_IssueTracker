import "./List.css";
import Issue from "./Issue";
import { useRef, useState } from "react";
import { Routes, Route, useNavigate, Link } from "react-router-dom";

const issue = {};
const Prolist = ({ issues, onDelete }) => {
  const [search, setSearch] = useState("");

  // 이슈 검색
  const onChangeSearch = (e) => {
    setSearch(e.target.value);
  };

  const getFilteredData = () => {
    if (search === "") {
      return issues;
    }
    // 대소문자 구분 안 하게
    return issues.filter((issue) =>
      issue.i_name.toLowerCase().includes(search.toLowerCase())
    );
  };

  const filteredissues = getFilteredData();

  //이슈 등록

  return (
    <div className="List">
      <input placeholder="이슈 제목" />
      <input placeholder="이슈 내용" />

      <button>이슈 등록</button>

      <input
        value={search}
        onChange={onChangeSearch}
        placeholder="검색어를 입력하세요."
      />
      <Issue />
      <Issue />
      <Issue />
      <Issue />
    </div>
  );
};

export default Prolist;
