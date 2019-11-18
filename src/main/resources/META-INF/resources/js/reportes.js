(function(){
	idText = "";
	console.log("creando descargar");
	descargar = (id, nombre, fechaInicio, fechaFin)=>{
			console.log("haciendo fetch");
			
			let url = "http://localhost:8080/reportes?&id="+id+"&nombre="+nombre;
			
			if(nombre=="costos"){
				let inicioTemp = new Date(fechaInicio);
			      inicioTemp.setHours(0);
			      inicioTemp.setMinutes(0);
			      inicioTemp.setSeconds(0);

			      let finalTemp = new Date(fechaFin);
			      finalTemp.setHours(23);
			      finalTemp.setMinutes(59);
			      finalTemp.setSeconds(59);
			      
			      url += "&fechaInicio="+inicioTemp.getTime()+"&fechaFin="+finalTemp.getTime();
			}
			
		fetch(
		        url,
		        {
		          method: "GET"
		        }
		      )
		        .then(response => {
		          if (response.ok) {
		        	  console.log("obteniendo blob");
		            response.blob().then(blob => {
		              // 2. Create blob link to download
		              const url = window.URL.createObjectURL(new Blob([blob]));
		              const link = document.createElement("a");
		              link.href = url;

		              link.setAttribute(
		                "download",
		                "reporte"+nombre+".pdf"
		              );
		              // 3. Append to html page
		              document.body.appendChild(link);
		              // 4. Force download
		              link.click();
		              // 5. Clean up and remove the link
		              link.parentNode.removeChild(link);
		            });
		          }
		        })
		        .catch(e => {
		          console.log("error")
 					        }); }

})();