import { Component } from '@angular/core';
import { Persona } from '../modelo/Persona';
import { PersonaService } from 'src/app/services/persona.service';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.scss']
})
export class InicioComponent {

  personas: any

  per: Persona = new Persona()



  constructor(private personaService: PersonaService){

  }

  ngOnInit(): void {
      this.personas = this.personaService.getClientes()
  }

  guardar(){
    if(this.per.Codigo){
    this.personaService.actualizarCliente(this.per).subscribe(data => {
      console.log(data);
      if (data.codigo !== 0) {
        this.ngOnInit();
      } else {
        alert("Error al actualizar " + data.mensaje);
      }
    });
  }else{
    this.personaService.saveCliente(this.per).subscribe(data => {
      console.log(data)
      if(data.codigo !== 0)
        this.ngOnInit()
      else
        alert("Error al insertar " + data.mensaje)
    });
  }
  }

  eliminar(codigo: number){
      this.personaService.deleteCliente(codigo).subscribe(data => {
        console.log(data);
    });
    this.ngOnInit();
  }

}
