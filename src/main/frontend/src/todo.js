import axios from "axios";
import { useEffect, useState } from "react";
import "./todo.css";

function Todo() {
  const [todoList, setTodoList] = useState([]);
  const [content, setContent] = useState("");

  const [updatedContent, setUpdatedContent] = useState("");
  const [modalOpen, setModalOpen] = useState(false);
  const [selectedTodo, setSelectedTodo] = useState(null);

  const handleContentChange = (e) => {
    setContent(e.target.value);
  };

  const fetchData = async () => {
    try {
      const result = await axios.get("/api/todo");
      setTodoList([...result.data]);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  const handleTodoClick = (todo) => {
    setSelectedTodo(todo);
    setModalOpen(true);
  };

  const handleTodoDelete = async () => {
    try {
      await axios.delete(`/api/todo/delete/${selectedTodo.id}`);
      setTodoList(todoList.filter((todo) => todo.id !== selectedTodo.id));
      setModalOpen(false);
      setSelectedTodo(null);
    } catch (error) {
      console.log(error);
    }
  };

  const handleUpdatedContentChange = (e) => {
    setUpdatedContent(e.target.value);
  };

  const handleTodoUpdate = async (e) => {
    e.preventDefault();
    try {
      const updatedTodo = { ...selectedTodo, content: updatedContent };
      const result = await axios.put(
        `/api/todo/update/${updatedTodo.id}`,
        updatedTodo
      );

      setTodoList((prevTodoList) =>
        prevTodoList.map((todo) =>
          todo.id === updatedTodo.id ? { ...todo, ...result.data } : todo
        )
      );
      setSelectedTodo(null);
      setUpdatedContent("");
      setModalOpen(false);
    } catch (error) {
      console.log(error);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const result = await axios.post(`/api/todo/create`, null, {
        params: { content },
      });
      setTodoList((prevTodoList) => [...prevTodoList, result.data]);
      setContent("");
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div>
      <h1>🌻 Todo</h1>
      <form onSubmit={handleSubmit}>
        <input type="text" value={content} onChange={handleContentChange} />
        <button type="submit">작성</button>
      </form>
      <div>
        {todoList.map((todo) => {
          return (
            <li
              key={todo.id}
              className={todo.completed ? "completed" : ""}
              onClick={() => handleTodoClick(todo)}
            >
              {todo.content} {todo.completed ? "✓" : ""}
            </li>
          );
        })}
      </div>
      {modalOpen && (
        <div className="modal-container">
          <form onSubmit={handleTodoUpdate}>
            <input
              type="text"
              value={updatedContent}
              onChange={handleUpdatedContentChange}
            />
            <button type="submit">수정</button>
          </form>
          <button onClick={handleTodoDelete}>삭제</button>
          <button onClick={() => setModalOpen(false)}>닫기</button>
        </div>
      )}
    </div>
  );
}

export default Todo;
