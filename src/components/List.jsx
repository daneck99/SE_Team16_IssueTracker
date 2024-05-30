import "./List.css";
import Project from "./Project";
import { useState } from "react";
import { Routes, Route, useNavigate, Link } from "react-router-dom";

const List = ({ projects, onDelete }) => {
  const [search, setSearch] = useState("");
  // 검색
  const onChangeSearch = (e) => {
    setSearch(e.target.value);
  };

  const getFilteredData = () => {
    if (search === "") {
      return projects;
    }
    // 대소문자 구분 안 하게
    return projects.filter((project) =>
      project.p_name.toLowerCase().includes(search.toLowerCase())
    );
  };

  const filteredprojects = getFilteredData();

  return (
    <div className="List">
      <input
        value={search}
        onChange={onChangeSearch}
        placeholder="검색어를 입력하고 Enter를 누르세요."
      />

      <div className="Project_wrapper">
        {filteredprojects.map((project) => {
          return (
            <Project key={project.p_id} {...project} onDelete={onDelete} />
          );
        })}
      </div>
    </div>
  );
};

export default List;
