import "./Project.css";
import Issue from "./Issue";
import { useState } from "react";
import { Routes, Route, useNavigate, Link } from "react-router-dom";

// 디비에서 받아와서 해야될듯

const Comment = (comment_id, contents, commented_time, writer_id) => {
  return (
    <>
      <div className="Project">
        <div>contents</div>
        <div className="date">commented_time</div>
        <div>작성자</div>
      </div>
    </>
  );
};

export default Comment;
