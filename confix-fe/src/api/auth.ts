import api from "./axios";

export interface LoginInput {
  username: string;
  password: string;
}

export interface RegisterInput {
  firstName: string;
  lastName: string;
  username: string;
  email: string;
  password: string;
  phoneNumber?: string;
  birthDate?: string;
}

export interface ChangePasswordInput {
  token: string;
  newPassword: string;
}

export const loginUser = (data: LoginInput) => {
  return api.post("/auth/login", data).then((res) => res.data);
};

export const registerUser = (data: RegisterInput) => {
  return api.post("/auth/register", data).then((res) => res.data);
};

export const changePassword = (data: ChangePasswordInput) => {
  return api.post("/auth/change-password", data).then((res) => res.data);
};

export async function fetchMe() {
  const { data } = await api.get("/me");
  return data;
}

export interface ForgotPasswordInput {
  email: string;
}
export interface ResetPasswordInput {
  token: string;
  newPassword: string;
}

export const forgotPassword = (data: ForgotPasswordInput) =>
  api.post("/auth/forgot-password", data).then((res) => res.data);

export const resetPassword = (data: ResetPasswordInput) =>
  api.post("/auth/reset-password", data).then((res) => res.data);
