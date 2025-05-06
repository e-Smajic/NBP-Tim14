/* eslint-disable @typescript-eslint/no-explicit-any */
import {
  Title,
  Text,
  TextInput,
  PasswordInput,
  Button,
  Anchor,
  Box,
} from "@mantine/core";
import { useForm } from "@mantine/form";
import { showNotification } from "@mantine/notifications";
import { Link, useNavigate } from "react-router-dom";
import { useRegister } from "../../../hooks/useAuth";
import { motion } from "framer-motion";
import { AuthLayout } from "../../../components/AuthLayout/AuthLayout";

export function RegisterPage() {
  const form = useForm({
    initialValues: {
      firstName: "",
      lastName: "",
      username: "",
      email: "",
      password: "",
      phoneNumber: "",
      birthDate: "",
    },
    validate: {
      firstName: (v) => (v.trim() ? null : "First name is required"),
      lastName: (v) => (v.trim() ? null : "Last name is required"),
      username: (v) => (v.trim() ? null : "Username is required"),
      email: (v) => (/^\S+@\S+$/.test(v) ? null : "Please enter a valid email"),
      password: (v) =>
        v.length >= 6 ? null : "Password must be at least 6 characters",
    },
  });

  const register = useRegister();
  const nav = useNavigate();

  // same onSuccess/onError mapping as before…
  const handleClick = () => {
    const validation = form.validate();
    if (validation.hasErrors) {
      showNotification({
        title: "Oops!",
        message: "Please fix the highlighted errors",
        color: "red",
      });
      return;
    }
    register.mutate(form.values, {
      onSuccess: () => {
        showNotification({
          title: "Success",
          message: "Account created! You can now log in.",
          color: "green",
        });
        nav("/login");
      },
      onError: (e: any) => {
        const code = e.response?.data?.error;
        let message = "Registration failed. Please try again.";
        if (code === "username-taken") {
          message = "That username is already taken.";
        } else if (code === "email-taken") {
          message = "That email is already registered.";
        }
        showNotification({ title: "Error", message, color: "red" });
      },
    });
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
          Create Account
        </Title>
        <Text c="gray" ta="center" mb="lg">
          Join Confix and start managing containers.
        </Text>

        <Box component="form" noValidate>
          <TextInput
            label="First Name"
            required
            {...form.getInputProps("firstName")}
            error={form.errors.firstName}
          />

          <TextInput
            label="Last Name"
            required
            mt="md"
            {...form.getInputProps("lastName")}
            error={form.errors.lastName}
          />

          <TextInput
            label="Username"
            required
            mt="md"
            {...form.getInputProps("username")}
            error={form.errors.username}
          />

          <TextInput
            label="Email"
            required
            mt="md"
            {...form.getInputProps("email")}
            error={form.errors.email}
          />

          <PasswordInput
            label="Password"
            required
            mt="md"
            {...form.getInputProps("password")}
            error={form.errors.password}
          />

          <TextInput
            label="Phone Number (optional)"
            placeholder="+38761234567"
            mt="md"
            {...form.getInputProps("phoneNumber")}
          />

          <TextInput
            label="Birth Date (optional)"
            type="date"
            mt="md"
            {...form.getInputProps("birthDate")}
          />

          <Button
            fullWidth
            mt="xl"
            loading={register.isPending}
            onClick={handleClick}
          >
            Register
          </Button>
        </Box>

        <Text ta="center" mt="md">
          Already have an account?{" "}
          <Anchor component={Link} to="/login">
            Login
          </Anchor>
        </Text>
      </motion.div>
    </AuthLayout>
  );
}
