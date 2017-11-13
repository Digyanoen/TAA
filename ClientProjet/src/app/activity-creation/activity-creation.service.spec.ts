import { TestBed, inject } from '@angular/core/testing';

import { ActivityCreationService } from './activity-creation.service';

describe('ActivityCreationService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ActivityCreationService]
    });
  });

  it('should be created', inject([ActivityCreationService], (service: ActivityCreationService) => {
    expect(service).toBeTruthy();
  }));
});
