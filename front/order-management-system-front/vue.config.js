module.exports = {
    devServer: {
        proxy: {
            '/api': {
                target: 'http://47.93.190.166:9999/system', //接口域名
                changeOrigin: true,       //是否跨域
                ws: true,            //是否代理 websockets
                secure: true,          //是否https接口
                pathRewrite: {         //路径重置
                    '^/api': ''
                }
            },
            '/img':{
                target: 'http://47.93.190.166:9999/system/file/getFile', //接口域名
                changeOrigin: true,       //是否跨域
                ws: true,            //是否代理 websockets
                secure: true,          //是否https接口
                pathRewrite: {         //路径重置
                    '^/img': ''
                }
            }
        }
    }
};