import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListPathComponent } from './list-path.component';

describe('ListPathComponent', () => {
  let component: ListPathComponent;
  let fixture: ComponentFixture<ListPathComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListPathComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListPathComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
