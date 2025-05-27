import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MyOrdersComponent } from '../my-orders.component';

describe('MyOrdersComponent', () => {
  let component: MyOrdersComponent;
  let fixture: ComponentFixture<MyOrdersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MyOrdersComponent]
    }).compileComponents();

    fixture = TestBed.createComponent(MyOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should verify an order', () => {
    component.verifyOrder(1);
    const order = component.orders.find(o => o.id === 1);
    expect(order?.verified).toBeTrue();
  });

  it('should not crash on invalid order ID', () => {
    expect(() => component.verifyOrder(999)).not.toThrow();
  });
});
