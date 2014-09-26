/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



  // oikeasti välitys
  
  $(document).ready(function(){
     $('.open-muokkaaModal').bind('click', function(){
          var id = $(this).attr('data-id');
          $('#id-kentta').val(id);
          
          var nimi = $(this).attr('data-nimi');
          var hinta = $(this).attr('data-hinta');
          var osoite = $(this).attr('data-osoite');
          var maxVaraukset = $(this).attr('data-maxVaraukset');
          
          $('#nimiKentta').val(nimi);
          $('#hintaKentta').val(hinta);
          $('#osoiteKentta').val(osoite);
          $('#maxVarauksetKentta').val(maxVaraukset);
          console.log('klikattu');
     });
  });
  
  

