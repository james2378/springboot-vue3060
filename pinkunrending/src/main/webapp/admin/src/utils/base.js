const base = {
    get() {
        return {
            url : "http://localhost:8080/pinkunrending/",
            name: "pinkunrending",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/pinkunrending/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "贫困认定管理平台"
        } 
    }
}
export default base
