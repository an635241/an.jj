$.fn.fixedHeaderTable=function(fixedColumns,divHeight){
	  
	$(this).find("th").each(function(){
  		$(this).html("<nobr>"+$(this).text()+"</nobr>");
  	});
	
	var id=$(this).attr('id');
	var datawidth=$(this).width();
	if(divHeight==null){
		divHeight=45;
	}
		
	if($(this).find('thead').length > 0 && $(this).find('th').length > 0) {
		var widthArray=new Array();
		$(this).find("thead tr:last th:not(:last)").each(function(){
			widthArray.push($(this).width());
		})
		$(this).removeClass("bordered");
		// copy table
		var $w	   = $(window),
			$t	   = $(this),
			$Headerd=$t.find('thead').clone(),
			$Headerdiv = $t.find('thead'),
			$col   = $t.find('tbody').clone(),
			$col2   = $t.find('tbody'),
			$fixedColumns=fixedColumns-1;
		
		var $table='';
		    $table=$table+'<tr>';  
		    $table=$table+'<td><div class="sticky-corner'+id+'" style="overflow: hidden;"><table class="bordered" style="width:100%;"></table></div></td>'; 
		    $table=$table+'<td><div class="sticky-head'+id+'" style="overflow: hidden;"><table class="bordered" style="width:100%;max-width:none;"></table></div></td>'; 
		    $table=$table+'</tr>'; 
		    $table=$table+'<tr>'; 
		    $table=$table+'<td><div class="sticky-col'+id+'" style=" overflow: hidden;"><table class="bordered"  style="table-layout:fixed;"></table></div></td>'; 
		    $table=$table+'<td><div class="maindiv'+id+'" style=" overflow: auto;" ><table class="bordered"  style="table-layout:fixed;max-width:none;"></table></div></td>'; 
		    $table=$table+'</tr>'; 
		    
		$t.html($table);

		$(this).find('.sticky-corner'+id+' table')
		.append($Headerd)
		.find('thead tr').each(function (i){
			$(this).find('th').each(function (j){
				if(j>$fixedColumns){$(this).remove();}
			});
		});
		
		$(this).find('.sticky-head'+id+' table')
		.append($Headerdiv)
		.find('thead tr').each(function (i){
			$(this).find('th').each(function (j){
				if(j<=$fixedColumns){$(this).remove();}
			});
		});
									
		$(this).find('.sticky-col'+id+' table')
		.append($col)
		.find('tbody tr').each(function (i){
			$(this).find('td').each(function (j){
				if(j>$fixedColumns){$(this).remove();}
			});
		});
		
		$(this).find('.maindiv'+id+' table')
		.append($col2)
		.find('tbody tr').each(function (i){
			$(this).find('td').each(function (j){
				if(j<=$fixedColumns){$(this).remove();}
			});
		});		
		var setSize=function(){				
			var headHeight=$(".sticky-corner"+id).height();
							
			var fixedWidth=0;
			for(i=1;i<=fixedColumns;i++){
				fixedWidth=fixedWidth+widthArray[i];
			}
			$('.sticky-col'+id).css('height',divHeight);  
			$('.maindiv'+id).css('height',divHeight);
						
			$('.sticky-head'+id).width($(window).width()-$('.sticky-corner'+id).width());			
			$('.maindiv'+id).width($(window).width()-$('.sticky-col'+id).width());
			
			$('.sticky-head'+id+' table').width(datawidth);
			$('.maindiv'+id+' table').width(datawidth);
		};
		
		setSize();

		//when browser resize ,resize the size
		$w.resize(function() {setSize();});
		
		for(i=0;i<widthArray.length;i++){
			if(i<fixedColumns){
				$(this).find(".sticky-corner"+id+" tr:last th:eq("+i+")").width(widthArray[i]);
				$(this).find(".sticky-col"+id+" tr:visible:first td:eq("+i+")").width(widthArray[i]);
				$(this).find(".sticky-col"+id+" tr:first td:eq("+i+")").width(widthArray[i]);
				$(this).find(".sticky-col"+id+" tr[group2='ZZ'] td:eq("+i+")").width(widthArray[i]);
				$(this).find(".sticky-col"+id+" tr[group2='合计'] td:eq("+i+")").width(widthArray[i]);
				$(this).find(".sticky-col"+id+" tr[group3='小计'] td:eq("+i+")").width(widthArray[i]);
			}else{
				$(this).find(".sticky-head"+id+" table tr:last th:eq("+(i-fixedColumns)+")").width(widthArray[i]);
				$(this).find(".maindiv"+id+" table tbody tr:visible:first td:eq("+(i-fixedColumns)+")").width(widthArray[i]);
				$(this).find(".maindiv"+id+" table tbody tr:first td:eq("+(i-fixedColumns)+")").width(widthArray[i]);
				$(this).find(".maindiv"+id+" table tbody tr[group2='ZZ'] td:eq("+(i-fixedColumns)+")").width(widthArray[i]);
				$(this).find(".maindiv"+id+" table tbody tr[group2='合计'] td:eq("+(i-fixedColumns)+")").width(widthArray[i]);
				$(this).find(".maindiv"+id+" table tbody tr[group3='小计'] td:eq("+(i-fixedColumns)+")").width(widthArray[i]);
			}
			
			//console.log(widthArray[i]);
		}
		
		//set scroll event
		$(this).find('.maindiv'+id).on("scroll",function(){
			$t.find('.sticky-head'+id).scrollLeft($t.find('.maindiv'+id).scrollLeft());
			$t.find('.sticky-col'+id).scrollTop($t.find('.maindiv'+id).scrollTop());
		});
	};

};