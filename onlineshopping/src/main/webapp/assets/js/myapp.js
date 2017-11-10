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
	var products = [
		
		['1','ABC'],
		['2','ZXC'],
		['3','ASD'],
		['4','QWE'],
		['5','RTY'],
		['6','UIO'],
		['7','OPI'],
		['8','FGH'],
		['9','JKL']
	];
	//console.log(products);
	var data = eval(products);
	var table = $('#productListTable').DataTable({
		

		data: data
		});
	
	
		
	


});
