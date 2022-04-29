function getPoetry(){
    var msg = {
        message:"获取诗歌"
    };

    $.ajax({
        type:"get",
        url:"poetry",
        data:msg,
        dataType:"json",
        success(res){
            console.log(res)
        },
        error(e){
            alert("发生了错误...")
        }
    })
}