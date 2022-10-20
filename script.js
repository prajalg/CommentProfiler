// const fs = require('fs') 
// function hello(mj)
// {
//   // window.location.href="templates/i.html";
//     fs.writeFileSync("x.json",mj);
// }
// function save(x)
// {
// const blob = new Blob([x], { type: 'application/json' });
// const file = new File([ blob ], 'file.json');
// }
// const fs = require('fs')
// const s=(dog)=>{
//   const finished = (error)=>{
//     if(error)
//     {
//       console.error(error);
//       return;
//     }
//   }
//   const jd = JSON.stringify(dog)
//   fs.writeFile('dog.json',jd,finished)
// }
document.getElementById("hello").addEventListener("click", function  (e) {
  e.preventDefault();
  var arr = [];
  var vi = $("#vi").val();
  var api = "AIzaSyDwE0wBmelnNY4bkLGF3t6olDtHsddmKLQ";
  var url =
    "https://www.googleapis.com/youtube/v3/commentThreads?part=snippet&key=" +
    api +
    "&videoId=" +
    vi +
    "&maxResults=100";
  var x ;
  
  $.get(url, function (data) {
    console.log(data);
    console.log(data.pageInfo.totalResults);
    arr = arr.concat(data.items);
    var npt = data.nextPageToken;
    if (npt == undefined) {
      console.log("hogaya");
      console.log(arr);
      mj = { items: arr };
      // s(mj);
      console.log(mj);
      x = JSON.stringify(mj);
      console.log(x);
      // save(x);
      hello(mj);
    } else {
      url = url + "&pageToken=" + npt;
      $.get(url, function (d) {
        console.log(d);
        console.log(data.pageInfo.totalResults);
        arr = arr.concat(data.items);
        npt = d.nextPageToken;
        if (npt == undefined) {
          console.log("hogaya");
          console.log(arr);
          mj = { items: arr };
          // s(mj);
          console.log(mj);
          hello(mj);
        } else {
          console.log("hogaya");
          console.log(arr);
          
          mj = { items: arr };
          // s(mj);
          console.log(mj);
         hello(mj);
        }
      });
    }
  });
  console.log("hello");
});
