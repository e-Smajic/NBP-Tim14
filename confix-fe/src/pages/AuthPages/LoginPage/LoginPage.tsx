/* eslint-disable @typescript-eslint/no-explicit-any */
import {
  Title,
  Text,
  TextInput,
  PasswordInput,
  Checkbox,
  Button,
  Anchor,
  Group,
  Box,
} from "@mantine/core";
import { useForm } from "@mantine/form";
import { showNotification } from "@mantine/notifications";
import { Link, useNavigate } from "react-router-dom";
import { useLogin } from "../../../hooks/useAuth";
import { motion } from "framer-motion";
import { AuthLayout } from "../../../components/AuthLayout/AuthLayout";

export function LoginPage() {
  const form = useForm({
    initialValues: { username: "", password: "", remember: false },
    validate: {
      username: (v) => (v.trim() ? null : "Username is required"),
      password: (v) =>
        v.length >= 6 ? null : "Password must be at least 6 characters",
    },
  });

  const login = useLogin();
  const nav = useNavigate();

  const handleClick = () => {
    const validation = form.validate();
    if (validation.hasErrors) {
      showNotification({
        title: "Validation Error",
        message: "Please fix the highlighted fields before submitting.",
        color: "red",
      });
      return;
    }

    login.mutate(
      { username: form.values.username, password: form.values.password },
      {
        onSuccess: () => {
          showNotification({
            title: "Welcome back!",
            message: "You’re now logged in.",
            color: "green",
          });
          nav("/");
        },
        onError: () => {
          showNotification({
            title: "Login Failed",
            message: "Invalid credentials. Please try again.",
            color: "red",
          });
        },
      }
    );
  };

  const variants = {
    initial: { opacity: 0, scale: 0.95 },
    animate: { opacity: 1, scale: 1 },
    exit: { opacity: 0, scale: 0.95 },
  };

  return (
    <AuthLayout>
      <motion.div
        variants={variants}
        initial="initial"
        animate="animate"
        exit="exit"
        transition={{ duration: 0.4, ease: "easeOut" }}
      >
        <Title order={2} ta="center">
          Welcome To Confix
        </Title>
        <Text c="gray" ta="center" mb="lg">
          Your all-in-one container management solution.
        </Text>

        <Box component="form" noValidate>
          <TextInput
            label="Username"
            required
            {...form.getInputProps("username")}
            error={form.errors.username}
          />

          <PasswordInput
            label="Password"
            mt="md"
            required
            {...form.getInputProps("password")}
            error={form.errors.password}
          />

          <Group justify="space-between" mt="lg" align="center">
            <Checkbox
              label="Keep me logged in"
              {...form.getInputProps("remember", { type: "checkbox" })}
            />
            <Anchor component={Link} to="/forgot-password" size="sm">
              Forgot password?
            </Anchor>
          </Group>

          <Button
            fullWidth
            mt="xl"
            loading={login.isPending}
            onClick={handleClick}
          >
            Login
          </Button>
        </Box>

        <Text ta="center" mt="md">
          Don’t have an account?{" "}
          <Anchor component={Link} to="/register">
            Register
          </Anchor>
        </Text>
      </motion.div>
    </AuthLayout>
  );
}
