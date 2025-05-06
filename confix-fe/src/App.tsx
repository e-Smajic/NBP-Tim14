import { Routes, Route } from "react-router-dom";
import { AnimatePresence } from "framer-motion";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";

import { LoginPage } from "./pages/AuthPages/LoginPage/LoginPage";
import { RegisterPage } from "./pages/AuthPages/RegisterPage/RegisterPage";
import { ChangePasswordPage } from "./pages/AuthPages/ChangePasswordPage/ChangePasswordPage";
import { HomePage } from "./pages/HomePage/HomePage";
import { RequireAuth } from "./components/RequireAuth/RequireAuth";
import { ForgotPasswordPage } from "./pages/AuthPages/ForgotPasswordPage/ForgotPasswordPage";
import { ResetPasswordPage } from "./pages/AuthPages/ResetPasswordPage/ResetPasswordPage";

const qc = new QueryClient();

export default function App() {
  return (
    <QueryClientProvider client={qc}>
      <AnimatePresence mode="wait">
        <Routes>
          {/* public */}
          <Route path="/login" element={<LoginPage />} />
          <Route path="/register" element={<RegisterPage />} />
          <Route path="/forgot-password" element={<ForgotPasswordPage />} />
          <Route path="/reset-password" element={<ResetPasswordPage />} />

          {/* guarded */}
          <Route element={<RequireAuth />}>
            <Route path="/" element={<HomePage />} />
            <Route path="/change-password" element={<ChangePasswordPage />} />
          </Route>
        </Routes>
      </AnimatePresence>
    </QueryClientProvider>
  );
}
