const { defineConfig } = require('@vue/cli-service');

module.exports = defineConfig({
  transpileDependencies: true,
  chainWebpack: config => {
    config.plugin('define').tap(args => {
      const env = args[0] || {};
      env['__VUE_PROD_HYDRATION_MISMATCH_DETAILS__'] = true; // ou false selon vos besoins
      return [env];
    });
  }
});

