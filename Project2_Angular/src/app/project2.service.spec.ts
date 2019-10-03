import { TestBed } from '@angular/core/testing';

import { Project2Service } from './project2.service';

describe('Project2Service', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: Project2Service = TestBed.get(Project2Service);
    expect(service).toBeTruthy();
  });
});
