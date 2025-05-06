/* eslint-disable @typescript-eslint/no-explicit-any */
import { Title, Text, PasswordInput, Button } from "@mantine/core";
import { useForm } from "@mantine/form";
import { showNotification } from "@mantine/notifications";
import { useNavigate, useSearchParams, Link } from "react-router-dom";
import { useResetPassword } from "../../../hooks/useAuth";
import { motion } from "framer-motion";
import { AuthLayout } from "../../../components/AuthLayout/AuthLayout";

export function ResetPasswordPage() {
  const [params] = useSearchParams();
  const token = params.get("token") || "";
  const form = useForm({
    initialValues: { newPassword: "", confirm: "" },
    validate: {
      newPassword: (v) => (v.length >= 6 ? null : "Password too short"),
      confirm: (v, values) =>
        v === values.newPassword ? null : "Passwords must match",
    },
  });
  const mutation = useResetPassword();
  const nav = useNavigate();

  const onSubmit = form.onSubmit((vals) =>
    mutation.mutate(
      { token, newPassword: vals.newPassword },
      {
        onSuccess: () => {
          showNotification({ message: "Password reset!", color: "green" });
          nav("/login");
        },
        onError: (e: any) => {
          showNotification({
            message: e.response?.data?.error ?? "Reset failed",
            color: "red",
          });
        },
      }
    )
  );

  const fadeScaleVariants = {
    initial: { opacity: 0, scale: 0.95 },
    animate: { opacity: 1, scale: 1 },
    exit: { opacity: 0, scale: 0.95 },
  };

  const fadeScaleTransition = {
    duration: 0.4,
    ease: "easeOut",
  };

  return (
    <AuthLayout>
      <motion.div
        variants={fadeScaleVariants}
        initial="initial"
        animate="animate"
        exit="exit"
        transition={fadeScaleTransition}
      >
        <Title order={2} ta="center">
          Reset Password
        </Title>
        <Text c="gray" ta="center" mb="lg">
          Choose a new password for your account.
        </Text>
        <form onSubmit={onSubmit}>
          <PasswordInput
            label="New Password"
            {...form.getInputProps("newPassword")}
            required
          />
          <PasswordInput
            label="Confirm Password"
            mt="md"
            {...form.getInputProps("confirm")}
            required
          />
          <Button type="submit" fullWidth mt="xl" loading={mutation.isPending}>
            Reset Password
          </Button>
        </form>
        <Text ta="center" mt="md">
          <Link to="/login">Back to Login</Link>
        </Text>
      </motion.div>
    </AuthLayout>
  );
}
