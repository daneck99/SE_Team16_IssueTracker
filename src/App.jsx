import { useState } from "react";
import "./App.css";

function App() {
  const [showResults, setShowResults] = useState(false);

  const handleSearch = (e) => {
    e.preventDefault();
    setShowResults(true);
  };

  return (
    <div className="App">
      <header>
        <h1>월 별 이슈 발생 횟수</h1>
      </header>

      <section className="notification">
        <p>📌월 별 발생한 이슈의 횟수를 조회하는 페이지입니다.</p>
        <p>📌이슈 발생 횟수를 조회하고자 하는 월의 시작과 끝을 선택하십시오.</p>
      </section>

      <section className="search">
        <h3>▶ 검색조건</h3>
        <form onSubmit={handleSearch}>
          <label htmlFor="startDate">시작 월:</label>
          <select id="startDate" name="startDate">
            <option value="">--- 선택 ---</option>
            <option value="1">1월</option>
            <option value="2">2월</option>
            <option value="3">3월</option>
            <option value="4">4월</option>
            <option value="5">5월</option>
            <option value="6">6월</option>
            <option value="7">7월</option>
            <option value="8">8월</option>
            <option value="9">9월</option>
            <option value="10">10월</option>
            <option value="11">11월</option>
            <option value="12">12월</option>
          </select>

          <label htmlFor="endDate">끝 월:</label>
          <select id="endDate" name="endDate">
            <option value="">--- 선택 ---</option>
            <option value="1">1월</option>
            <option value="2">2월</option>
            <option value="3">3월</option>
            <option value="4">4월</option>
            <option value="5">5월</option>
            <option value="6">6월</option>
            <option value="7">7월</option>
            <option value="8">8월</option>
            <option value="9">9월</option>
            <option value="10">10월</option>
            <option value="11">11월</option>
            <option value="12">12월</option>
          </select>

          <button type="submit">검색</button>
        </form>
      </section>

      {showResults && (
        <section className="result">
          <h3>▶ 검색결과</h3>
          <table>
            <thead>
              <tr>
                <td>*결과 있을 때 막대 그래프 띄우기*</td>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td colSpan="7">검색 결과가 없습니다.</td>
              </tr>
            </tbody>
          </table>
        </section>
      )}
    </div>
  );
}

export default App;
