import { TestBed } from '@angular/core/testing';

import { FeatureCollectionServiceService } from './feature-collection-service.service';

describe('FeatureCollectionServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FeatureCollectionServiceService = TestBed.get(FeatureCollectionServiceService);
    expect(service).toBeTruthy();
  });
});
