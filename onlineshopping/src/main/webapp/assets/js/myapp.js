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



});

