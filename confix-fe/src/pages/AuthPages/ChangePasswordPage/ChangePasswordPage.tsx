import { Button, PasswordInput, Paper, Title, Box } from "@mantine/core";
import { useForm } from "@mantine/form";
import { showNotification } from "@mantine/notifications";
import { useSearchParams, useNavigate } from "react-router-dom";
import { useChangePassword } from "../../../hooks/useAuth";

export function ChangePasswordPage() {
  const [params] = useSearchParams();
  const token = params.get("token") ?? "";
  const navigate = useNavigate();
  const mutation = useChangePassword();

  const form = useForm({
    initialValues: { newPassword: "" },
    validate: {
      newPassword: (v) =>
        v.length >= 6 ? null : "Password must be at least 6 characters",
    },
  });

  const handleClick = () => {
    const validation = form.validate();
    if (validation.hasErrors) {
      showNotification({
        title: "Validation Error",
        message: validation.errors.newPassword,
        color: "red",
      });
      return;
    }

    mutation.mutate(
      { token, newPassword: form.values.newPassword },
      {
        onSuccess: () => {
          showNotification({
            title: "Success",
            message: "Your password was changed.",
            color: "green",
          });
          navigate("/login");
        },
        onError: () => {
          showNotification({
            title: "Error",
            message: "Failed to change password. Please try again.",
            color: "red",
          });
        },
      }
    );
  };

  return (
    <Paper radius="md" p="xl" withBorder>
      <Title order={2} ta="center">
        Change Password
      </Title>

      <Box component="form" noValidate>
        <PasswordInput
          label="New Password"
          {...form.getInputProps("newPassword")}
          error={form.errors.newPassword}
        />

        <Button
          fullWidth
          mt="xl"
          loading={mutation.isPending}
          onClick={handleClick}
        >
          Submit
        </Button>
      </Box>
    </Paper>
  );
}
