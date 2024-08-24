import { defineConfig } from "vite";
import react from "@vitejs/plugin-react-swc";

export default defineConfig({
  plugins: [react()],

  // We have to add this even though it did work
  // without it (and should) because:
  // "Sometimes, the same configuration works one
  // day, and stops working the next". -@nwoodr94 on GitHub
  server: {
    watch: {
      usePolling: true,
    },
  },
});
