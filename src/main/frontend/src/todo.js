import axios from "axios";
import { useEffect, useState } from "react";

function Todo() {
  const [todoList, setTodoList] = useState("");

  useEffect(() => {
    axios
      .get("/api/todo")
      .then((res) => {
        console.log(res.data);
      })
      .catch(function (error) {
        console.log(error);
      });
  }, []);

  return (
    <div>
      <h1>Todo List 🫧</h1>
    </div>
  );
}

export default Todo;
