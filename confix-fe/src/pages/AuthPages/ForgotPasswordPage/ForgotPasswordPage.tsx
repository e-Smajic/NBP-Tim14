/* eslint-disable @typescript-eslint/no-explicit-any */
import { Title, Text, TextInput, Button, Box } from "@mantine/core";
import { useForm } from "@mantine/form";
import { showNotification } from "@mantine/notifications";
import { useNavigate, Link } from "react-router-dom";
import { useForgotPassword } from "../../../hooks/useAuth";
import { motion } from "framer-motion";
import { AuthLayout } from "../../../components/AuthLayout/AuthLayout";

export function ForgotPasswordPage() {
  const form = useForm({
    initialValues: { email: "" },
    validate: {
      email: (v) => (/^\S+@\S+$/.test(v) ? null : "Please enter a valid email"),
    },
  });

  const mutation = useForgotPassword();
  const nav = useNavigate();

  const handleClick = () => {
    const validation = form.validate();
    if (validation.hasErrors) {
      showNotification({
        title: "Validation Error",
        message: "Enter a valid email address.",
        color: "red",
      });
      return;
    }

    mutation.mutate(
      { email: form.values.email },
      {
        onSuccess: () => {
          showNotification({
            title: "Email Sent",
            message: "Check your inbox for a reset link.",
            color: "green",
          });
          nav("/login");
        },
        onError: (e: any) => {
          showNotification({
            title: "Error",
            message: e.response?.data?.error ?? "Unable to send reset link.",
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
          Forgot Password
        </Title>
        <Text c="gray" ta="center" mb="lg">
          Enter your email to receive a reset link.
        </Text>

        <Box component="form" noValidate>
          <TextInput
            label="Email"
            placeholder="you@example.com"
            {...form.getInputProps("email")}
            error={form.errors.email}
          />

          <Button
            fullWidth
            mt="xl"
            loading={mutation.isPending}
            onClick={handleClick}
          >
            Send Reset Link
          </Button>
        </Box>

        <Text ta="center" mt="md">
          Remembered? <Link to="/login">Login</Link>
        </Text>
      </motion.div>
    </AuthLayout>
  );
}
