import axios from "axios";

const API_BASE_URL = "https://my-API-URL"; // 실제 API URL로 변경

export const fetchIssueStatistics = async () => {
  try {
    const response = await axios.get(`${API_BASE_URL}/issues/statistics`);
    return response.data;
  } catch (error) {
    console.error("Error fetching issue statistics:", error);
    throw error;
  }
};
