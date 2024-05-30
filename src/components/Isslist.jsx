import "./List.css";
import Comment from "./Comment";
import { useRef, useState } from "react";
import { Routes, Route, useNavigate, Link } from "react-router-dom";

const Isslist = ({ comments, onDelete }) => {
  //댓글 등록 : 백에서 구현..^^

  return (
    <>
      <div className="Listrow">
        <input placeholder="댓글을 입력하세요." />
        <button>등록</button>
      </div>

      <div>
        <Comment />
        <Comment />
        <Comment />
        <Comment />
      </div>
    </>
  );
};

export default Isslist;
