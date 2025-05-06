import React from "react";
import { Paper } from "@mantine/core";
import classes from "./AuthLayout.module.scss";

export const AuthLayout: React.FC<{ children: React.ReactNode }> = ({
  children,
}) => (
  <div className={classes.wrapper}>
    <Paper className={classes.form} radius={0} p="xl">
      {children}
    </Paper>
    <div className={classes.side} />
  </div>
);
