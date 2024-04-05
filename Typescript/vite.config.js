// vite.config.js
import { defineConfig } from "vite";
import _config from "./_config.js";

const HOST = _config.server.host;
const PORT = _config.server.port;

export default defineConfig({
  server: {
    host: HOST,
    port: PORT,
  },
});
