import { Outlet, Navigate } from "react-router-dom";
import { Center, Loader } from "@mantine/core";
import { useAuthStatus } from "../../hooks/useAuth";

export function RequireAuth() {
  const { data, isLoading, isError } = useAuthStatus();

  if (isLoading) {
    return (
      <Center h="100vh">
        <Loader />
      </Center>
    );
  }

  if (isError) {
    return <Navigate to="/login" replace />;
  }

  return <Outlet context={data} />;
}
