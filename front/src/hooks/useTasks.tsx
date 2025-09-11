import { useState } from "react";

type Task = {
  id: number;
  name: string;
  description: string;
  completed: boolean;
};

export function useTasks() {
  const [tasks, setTasks] = useState<Task[]>([]);

  const fetchTasks = async () => {
    const res = await fetch("http://localhost:8080/api/v1/tasks");
    const data = await res.json();
    console.log(data);
    setTasks(data);
  };

  return { tasks, fetchTasks };
}
