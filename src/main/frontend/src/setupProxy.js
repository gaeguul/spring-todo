const { createProxyMiddleware } = require("http-proxy-middleware");

// "/api"로 요청이 들어오면 localhost:8080으로 프록싱 함

module.exports = function (app) {
  app.use(
    "/api",
    createProxyMiddleware({
      target: "http://localhost:8080",
      changeOrigin: true,
    })
  );
};
