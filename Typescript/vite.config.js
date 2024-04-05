// vite.config.js
import { glsl } from "vite-plugin-glsl";
import { defineConfig } from "vite";
import _config from "./_config.js";
import { VitePluginNode } from 'vite-plugin-node';

const HOST = _config.server.host;
const PORT = _config.server.port;

export default defineConfig({
  plugins: [ VitePluginNode(), glsl()],
  server: {
    host: HOST,
    port: PORT,
  },
});
