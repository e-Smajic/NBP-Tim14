import {
  useMutation,
  useQuery,
  useQueryClient,
  type UseMutationResult,
} from "@tanstack/react-query";
import {
  loginUser,
  registerUser,
  changePassword,
  type LoginInput,
  type RegisterInput,
  type ChangePasswordInput,
  fetchMe,
  type ForgotPasswordInput,
  forgotPassword,
  resetPassword,
  type ResetPasswordInput,
} from "../api/auth";

type AuthError = {
  response?: { data?: { message?: string } };
};

export function useLogin(): UseMutationResult<boolean, AuthError, LoginInput> {
  const queryClient = useQueryClient();

  return useMutation<boolean, AuthError, LoginInput>({
    mutationFn: loginUser,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ["me"] });
    },
    onError: (error) => {
      console.error("Login failed:", error.response?.data?.message);
    },
  });
}

export function useRegister(): UseMutationResult<
  boolean,
  AuthError,
  RegisterInput
> {
  const queryClient = useQueryClient();

  return useMutation<boolean, AuthError, RegisterInput>({
    mutationFn: registerUser,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ["users"] });
    },
    onError: (error) => {
      console.error("Registration failed:", error.response?.data?.message);
    },
  });
}

export function useChangePassword(): UseMutationResult<
  boolean,
  AuthError,
  ChangePasswordInput
> {
  return useMutation<boolean, AuthError, ChangePasswordInput>({
    mutationFn: changePassword,
    onSuccess: () => {
      console.log("Password change successful");
    },
    onError: (error) => {
      console.error("Password change failed:", error.response?.data?.message);
    },
  });
}

export function useAuthStatus() {
  return useQuery({
    queryKey: ["me"],
    queryFn: fetchMe,
    retry: false,
    refetchOnWindowFocus: false,
  });
}

export function useForgotPassword(): UseMutationResult<
  void,
  AuthError,
  ForgotPasswordInput
> {
  return useMutation<void, AuthError, ForgotPasswordInput>({
    mutationFn: forgotPassword,
    onError: (error) => {
      console.error("Forgot password failed:", error.response?.data?.message);
    },
  });
}

export function useResetPassword(): UseMutationResult<
  void,
  AuthError,
  ResetPasswordInput
> {
  return useMutation<void, AuthError, ResetPasswordInput>({
    mutationFn: resetPassword,
    onError: (error) => {
      console.error("Reset password failed:", error.response?.data?.message);
    },
  });
}
