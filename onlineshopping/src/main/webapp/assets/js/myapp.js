$(function(){
	
	switch(menu){
	
	case 'About Us':
		$('#about').addClass('active');
		$('#home').removeClass('active');
		break;
		
		case 'Contact Us':
			$('#contact').addClass('active');
			$('#home').removeClass('active');
			break;
			
		case 'All Products':
			$('#listProducts').addClass('active');
			$('#home').removeClass('active');
			break;
			
		case 'Home':
			$('#home').addClass('active');
			break;
		
		default:
				$('#listProducts').addClass('active');
				$('#a_'+menu).addClass('active');
				$('#home').removeClass('active');
				break;
	}

	
	//code for jquery dataTable
	//create a dataset
	/*var products = [
		
		['1','ABC'],
		['2','ZXC'],
		['3','ASD'],
		['4','QWE'],
		['5','RTY'],
		['6','UIO'],
		['7','OPI'],
		['8','FGH'],
		['9','JKL']
	];*/
	//console.log(products);
//	var data = eval(products);
	//var table = $('#productListTable');
	
	if($('#productListTable').length){
		var jsonUrl = '';
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products';
			console.log("goutham : "+jsonUrl);
		} else{
			
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
			console.log("goutham : "+jsonUrl);
		}
		$('#productListTable').DataTable({
		lengthMenu: [[3,5,10,-1],['3 RECORDS','5 RECORDS','10 RECORDS','ALL']],
		pageLength:5,
		/*data: data*/
		ajax:{
			url:jsonUrl,
			dataSrc:''
			
		},
		columns:[
			{
				data: 'code',
				mRender: function(data, type, row){
					
					return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/> ';
					
				}
			},
			{
				data:'name'
			},
			{
				data:'brand'
			},
			{
				data:'unitPrice',
				mRender: function(data, type, row){
					return '&#8377; ' + data
				}
			},
			{
				data:'quantity',
				mRender : function(data, type, row) {

					if (data < 1) {
						return '<span style="color:red">Out of Stock!</span>';
					}

					return data;

				}
			},
			{
				data: 'id',
				bSortable: false,
				mRender: function(data, type, row) {
					var str='';
					str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary">View</a> &#160;';
					
					if (row.quantity < 1) {
						str += '<a href="javascript:void(0)" class="btn btn-success disabled">Add To Cart</a>';
					} else {
					str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success">Add To Cart</a>';
					}
					return str;
				}
			}
		]
		});
	}
	
		
	


});
