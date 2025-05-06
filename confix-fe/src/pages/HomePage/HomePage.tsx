import { Title, Text, Container } from "@mantine/core";

export function HomePage() {
  return (
    <Container size="sm" py="xl">
      <Title order={1}>Welcome to Confix</Title>
      <Text mt="md">
        This is your dashboard. From here you can manage containers, view
        reports, and keep track of repairs.
      </Text>
    </Container>
  );
}
